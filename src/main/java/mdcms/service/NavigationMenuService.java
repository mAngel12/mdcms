package mdcms.service;


import mdcms.model.NavigationMenu;

import java.util.List;

public interface NavigationMenuService {

    void addNav(NavigationMenu nav);

    List<NavigationMenu> getNavs();

    NavigationMenu getNav(int id);

    void deleteNav(int id);
}
