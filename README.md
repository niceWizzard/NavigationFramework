# Navigation Framework for Java Swing Applications

## Installation

1. Download the [NavigationFramework.jar](https://github.com/niceWizzard/NavigationFramework/blob/master/NavigationFramework.jar)
2. Add it as a library
3. Import the org.nice.navigation.\*!
4. Enjoy!

## Code Example

```java
import org.nice.navigation.*;


var nav = new NavigationPanel();

nav.addRoute("page1", new Page1());
nav.addRoute("page2", new Page2())

### Or you can also
var nav = new NavigationPanel(new NavRoute[] {
    new NavRoute(new Page1(), "page1"),
    new NavRoute(new Page2(), "page2")
})

// The default page will be the first page that is added

nav.navigateTo("page2");
nav.navigateTo("page1");

nav.navigateTo("nonexistentpage"); // Does nothing.
nav.navigateTo("page3", someData); // Pass data to the route page!

class Page1 extends Routeable {
    public Page1() {
        add(new JLabel("Page 1"));
    }
    @Override
    public void onNavigationEnter(Object... data) {

    }
    @Override
    public void onNavigationExit(String newRoute) {

    }
}
class Page2 extends Routeable {
    public Page2() {
        add(new JLabel("Page 2"));
    }
    @Override
    public void onNavigationEnter(Object... data) {

    }
    @Override
    public void onNavigationExit(String newRoute) {

    }
}

```
