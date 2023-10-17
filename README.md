<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [2023 TestWarez starting points](#2023-testwarez-starting-points)
- [Preconditions](#preconditions)
  - [Configure java/maven environment](#configure-javamaven-environment)
  - [Configure IDE](#configure-ide)
- [Workshop Instructions](#workshop-instructions)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# 2023 TestWarez workshop goals
During our workshop we will try to meet two goals:
* create automated tests for a demo e-commerce application
* create automated tests for a certain [mui](https://mui.com/material-ui/getting-started/) component 

You can choose any of the three frameworks to work with:
* [selenium](https://www.selenium.dev/) - if that's your choice, `selenium-master` is your starting point
* [selenide](https://selenide.org/) - if that's your choice, `selenide-master` is your starting point
* [playwright](https://playwright.dev/java/) - if that's your choice, `playwright-master` is your starting point

If you fancy any other framework I would appreciate if you had time to prepare similar starting point and push it to this repo.

# Preconditions

## Configure java/maven environment
Though the techniques we'll be learning can be used in any object-oriented language. The focus is on java as, still, the most popular one.
In `pom.xml` you will find:
```xml
<configuration>
  <source>21</source>
  <target>21</target>
</configuration>
```
Workshop though, is not tailored for any specific java version. You can easily change it according to your needs.
In case of lowering java version, please remember to remove `org.dudekre.testwarez2023.java21`. This package contains
presentation of `java 21` features most interesting from modeling perspective.

**Desired result**: `mvn test` pass

## Configure IDE
Workshop does not assume any particular IDE (you can use `vi` if you fancy), though I assume that you are an experienced
user of whatever integrated development environment you choose.

**Desired result**: you are able to run tests through IDE (unless you use `vi`, than `mvn test` will suffice :smirk:)

# Workshop Instructions
1. Checkout the code
2. Switch to the preferred starting point (I assume that you are an experienced user of the framework you've chosen - 
   the goal of our workshop is not to learn the framework but to practice designing)
3. Create your own master (e.g `playwright-master-remik`. I leave resolution of potential name collisions up to your imagination
4. Make sure that the `SwagLabsTest` is passing
5. You're ready to get started!!!

Looking forward to coding with You.
