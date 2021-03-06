package com.alexecollins.docker.orchestration.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ConfTest {
    private static final ObjectMapper MAPPER = new ObjectMapper(new YAMLFactory());
    private Conf conf;

    @Before
    public void setUp() throws Exception {
        conf = MAPPER.readValue(getClass().getResource("/conf.yml"), Conf.class);
    }

    @Test
    public void test() throws Exception {

        assertNotNull(conf.getTag());
        assertTrue(conf.hasTag());
        assertNotNull(conf.getLinks());
        assertNotNull(conf.getPackaging());
        assertNotNull(conf.getPorts());
        assertNotNull(conf.getVolumesFrom());

        assertEquals(new Link("foo:bar"), conf.getLinks().get(0));
        
        assertThat(conf.getMaxLogLines(), is(123));
    }

    @Test
    public void containerConf() throws Exception {
        ContainerConf container = conf.getContainer();
        assertTrue(container.hasName());
        assertEquals("theName", container.getName());
    }

    @Test
    public void enabled() throws Exception {
        assertEquals(true, conf.isEnabled());
    }

    @Test
    public void volumes() throws Exception {
        assertEquals(Collections.singletonMap("foo", "bar"), conf.getVolumes());
    }

    @Test
    public void logPatterns() throws Exception {
        List<LogPattern> logPatterns = conf.getHealthChecks().getLogPatterns();
        List<Pattern> expected = Collections.singletonList(Pattern.compile("the-pattern"));
        assertEquals(expected.size(), logPatterns.size());
        LogPattern logPattern = logPatterns.get(0);
        assertEquals(expected.get(0).pattern(), logPattern.getPattern().pattern());
        assertEquals(30 * 1000, logPattern.getTimeout());
    }
}
