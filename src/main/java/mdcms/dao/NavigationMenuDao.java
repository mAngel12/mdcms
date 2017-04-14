package mdcms.dao;

import mdcms.model.NavigationMenu;

import java.util.List;

public interface NavigationMenuDao {

    void addNav(NavigationMenu nav);

    List<NavigationMenu> getNavs();

    NavigationMenu getNav(int id);

    void deleteNav(int id);
}
