package com.alexecollins.docker.orchestration;

import com.alexecollins.docker.orchestration.model.Id;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.*;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;


public class RepoTest {

    public static final String DOCKER_REPO = "docker-repo";
    private static final String PROJECT_VERSION = "1.0";
    private final Id appId = new Id("app");
    private final Id filterId = new Id("filter");
    private final Properties properties = new Properties();

    @Before
    public void setUp() throws Exception {
        properties.setProperty("project.version", PROJECT_VERSION);
    }

    @Test
    public void testSingleDependencies() throws Exception {
        final Map<Id, List<Id>> links = new HashMap<>();
        final Id a = new Id("a"), b = new Id("b");
        links.put(b, Collections.singletonList(a));
        links.put(a, Collections.<Id>emptyList());
        final ArrayList<Id> expected = new ArrayList<>();
        expected.add(a);
        expected.add(b);
        assertEquals(
                expected,
                defaultRepo().sort(links));
    }

    @Test
    public void testDoubleDependencies() throws Exception {
        final Map<Id, List<Id>> links = new HashMap<>();
        final Id a = new Id("a"), b = new Id("b"), c = new Id("c");
        links.put(c, Collections.singletonList(b));
        links.put(b, Collections.singletonList(a));
        links.put(a, Collections.<Id>emptyList());
        final ArrayList<Id> expected = new ArrayList<>();
        expected.add(a);
        expected.add(b);
        expected.add(c);
        assertEquals(
                expected,
                defaultRepo().sort(links));
    }

    @Test(expected = IllegalStateException.class)
    public void testCircularDependencies() throws Exception {
        final Map<Id, List<Id>> links = new HashMap<>();
        final Id a = new Id("a"), b = new Id("b"), c = new Id("c"), d = new Id("d"), e = new Id("e");
        links.put(c, Collections.singletonList(b));
        links.put(b, Collections.singletonList(a));
        links.put(a, Collections.singletonList(c));
        links.put(d, Collections.singletonList(e));
        links.put(e, Collections.<Id>emptyList());
        defaultRepo().sort(links);
    }

    private Repo defaultRepo() {
        return repo(DOCKER_REPO);
    }

    @Test(expected = IllegalStateException.class)
    public void testSelfCircularDependencies() throws Exception {
        final Map<Id, List<Id>> links = new HashMap<>();
        final Id a = new Id("a");
        links.put(a, Collections.singletonList(a));
        defaultRepo().sort(links);
    }

    @Test
    public void testPropertiesReplaced() throws Exception {
        assertEquals("example-" + PROJECT_VERSION + ".jar", defaultRepo().conf(appId).getPackaging().getAdd().get(0).getPath());
    }

    @Test
    public void filesAreNotIncludedInIds() throws Exception {
        List<Id> identifiers = defaultRepo().ids(false);
        assertEquals(identifiers.size(), 2);
        assertThat(identifiers, hasItems(appId, filterId));
    }

    @Test
    public void cannotCreateRepoFromInvalidImage() throws Exception {
        try {
            repo("docker-invalid-image");
            fail();
        } catch (IllegalStateException e) {
            assertEquals("invalid repo, both image name and Dockerfile defined for app", e.getMessage());
        }
    }

    private Repo repo(String dockerRepo) {
        return new Repo("test", "test", new File("src/test", dockerRepo), properties);
    }
}
