Change Log
===
2.10.2

* [DJO Pull 47](https://github.com/alexec/docker-java-orchestration/pull/47) Bug: Fixed bug that prevented health-checking by IP on multiple containers.
* Enhancement: Made logging of failures clearer.
* Enhancement: Support new Docker VirtualBox set-up.

2.10.1

* Bug: Improved reliability of log health-check.

2.10.0

* [DJO Pull 39](https://github.com/alexec/docker-java-orchestration/pull/39) Enhancement: Added a health-check for making sure an expected log line appears.
* [DJO Pull 40](https://github.com/alexec/docker-java-orchestration/pull/40) Enhancement: Option to remove just containers on clean.
* [DJO Pull 41](https://github.com/alexec/docker-java-orchestration/pull/41) Enhancement: Option to ignore SSL issues on self-signed health-checks.
* Bug: Correctly validates of `Dockerfile` with periods in variable names.

2.9.3

* [DMP Issue 67](https://github.com/alexec/docker-maven-plugin/issues/67) Enhancement: Support privileged containers.
* [DMP Issue 70](https://github.com/alexec/docker-maven-plugin/issues/70) Bug: NPE is thrown with nameless containers.

2.9.0

* [DMP Issue 50](https://github.com/alexec/docker-maven-plugin/issues/50) Bug: Container port ordering was reversed.
* [DMP Issue 51](https://github.com/alexec/docker-maven-plugin/issues/51) Enhancement: ability to set container name.
* [DMP Issue 54](https://github.com/alexec/docker-maven-plugin/issues/54) Problems with port forwarding on Windows.
* [DJO Pull 25](https://github.com/alexec/docker-java-orchestration/pull/25) Added support for `src/main/docker/docker.yml` as a single global configuration file.
* [DJO Pull 27](https://github.com/alexec/docker-java-orchestration/pull/27) Enhancement: Improved logging.
* [DJO Pull 28](https://github.com/alexec/docker-java-orchestration/pull/28) Enhancement: Enabled/disable containers.
* [DJO Pull 33](https://github.com/alexec/docker-java-orchestration/pull/33) Enhancement: Image names. 
* [DJO Pull 34](https://github.com/alexec/docker-java-orchestration/pull/34) Enhancement: Support extra hosts.
* [DJO Pull 35](https://github.com/alexec/docker-java-orchestration/pull/35) Enhancement: Upgrade to docker-java:1.3.0.
* Other: removed un-needed code.

2.8.3

* Skip boot2docker if Unix.
* Added `permissionErrorTolerant` flag to deal with CircleCI btrfs errors.
* Migrated to CircleCI.

2.7.0

* Java 1.7
* [DJO Pull 22](https://github.com/alexec/docker-java-orchestration/pull/22) Container logs are printed on error.

2.6.0

* Updated to docker-java 1.2.0.
* Can now filter definitions using `DefinitionFilter`, e.g. to exclude some images from creation.

2.5.0

* Do not treat files in `src/main/docker` as containers, only directories.
* Made validation more tolerant to property filtering.
* Fixed bug so that images are no longer removed by default.
* Added ability to "quiet" builds.
* Fixed bug where images were always rebuilt.
* Added ability to sleep on starting a container.

2.4.0

* Added the ability to verify the body of a ping health-check.
* [DJO Issue 17](https://github.com/alexec/docker-java-orchestration/issues/17) Can disable filtering on "added" properties.
* [DJO Pull 18](https://github.com/alexec/docker-java-orchestration/pull/18) Added ability to validate your `Dockerfile`s.
* Exposed `DockerOrchestrator.builder()` to make it easier to build it.

2.3.1

* Fix splitting of tag name when tag contains port declaration for non-default registry.

2.3.0

* [DJO Pull 15](https://github.com/alexec/docker-java-orchestration/pull/15) Add method to get ID addresses.
* Changed to Apache 2.0 licence.
* [DJO Issue 32](https://github.com/alexec/docker-maven-plugin/issues/32) Added support for private repositories. 

2.2.0

* Provide a plugin system, and a boot2docker plugin that sets up port fowarding automatically.
* [DJO Issue 30](https://github.com/alexec/docker-maven-plugin/issues/30) Use version of docker-java that supports SSL.
* Improved error reporting on push.

2.1.0

* Fixed bug preventing correct linking of containers.
* [DMP Issue 26](https://github.com/alexec/docker-maven-plugin/issues/26) Support for link alias.
* Forcibly delete images.

2.0.2

* [DMP Pull 27](https://github.com/alexec/docker-maven-plugin/pull/27) Added environment and system properties.

2.0.1

* [DJO Pull 10](https://github.com/alexec/docker-java-orchestration/pull/10) Correctly preserve line endings on Windows. 
* [DJO Pull 11](https://github.com/alexec/docker-java-orchestration/pull/11) Use docker-java 0.10.2.
* [DJO Pull 12](https://github.com/alexec/docker-java-orchestration/pull/12) Correctly stop containers.


2.0.0

* Updated to use port 2375 by default.
* [DJO Issue 2](https://github.com/alexec/docker-java-orchestration/issues/2) Support for volumes.
* [DMP Issue 8](https://github.com/alexec/docker-maven-plugin/issues/8) Correct incorrect tag names.
* [DMP Issue 22](https://github.com/alexec/docker-maven-plugin/issues/22) Use docker-java.

1.4.0

* Support disabling of image caching.

1.3.1

* Fix issue with logging binary to console.

1.3.0

* Tag images.

1.2.0

* Remove intermediate containers.
* Support Windows.
 
1.1.0

* Pings containers to see if they are up before returning.
* Added a method the see if the container group is running.
* Will not attempt to start a running container (more idempotent).
* Fixed bug whereby the wrong container may be started.

1.0.2

* First release.

