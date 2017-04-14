package mdcms.service;

import mdcms.dao.NavigationMenuDao;
import mdcms.model.NavigationMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("navigationMenuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class NavigationMenuServiceImpl implements NavigationMenuService {

    @Autowired
    private NavigationMenuDao navigationMenuDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addNav(NavigationMenu nav) {
        navigationMenuDao.addNav(nav);
    }

    @Override
    public List<NavigationMenu> getNavs() {
        return navigationMenuDao.getNavs();
    }

    @Override
    public NavigationMenu getNav(int id) {
        return navigationMenuDao.getNav(id);
    }

    @Override
    public void deleteNav(int id) {
        navigationMenuDao.deleteNav(id);
    }
}
