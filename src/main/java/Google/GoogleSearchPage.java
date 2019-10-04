package Google;

import Base.BaseClass;

public class GoogleSearchPage extends BaseClass {

    private String searchBox = "//input[@name='q']";

    public void sendToSearchBox(String item){
        send(searchBox, item);
    }

}
