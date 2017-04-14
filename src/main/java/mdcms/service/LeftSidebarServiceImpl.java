package mdcms.service;

import mdcms.dao.LeftSidebarDao;
import mdcms.model.LeftSidebar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("leftSidebarService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LeftSidebarServiceImpl implements LeftSidebarService {

    @Autowired
    private LeftSidebarDao leftSidebarDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addPanel(LeftSidebar panel) {
        leftSidebarDao.addPanel(panel);
    }

    @Override
    public List<LeftSidebar> getPanels() {
        return leftSidebarDao.getPanels();
    }

    @Override
    public LeftSidebar getPanel(int id) {
        return leftSidebarDao.getPanel(id);
    }

    @Override
    public void deletePanel(int id) {
        leftSidebarDao.deletePanel(id);
    }
}
