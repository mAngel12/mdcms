package mdcms.service;

import mdcms.dao.RightSidebarDao;
import mdcms.model.RightSidebar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("rightSidebarService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RightSidebarServiceImpl implements RightSidebarService {

    @Autowired
    private RightSidebarDao rightSidebarDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addPanel(RightSidebar panel) {
        rightSidebarDao.addPanel(panel);
    }

    @Override
    public List<RightSidebar> getPanels() {
        return rightSidebarDao.getPanels();
    }

    @Override
    public RightSidebar getPanel(int id) {
        return rightSidebarDao.getPanel(id);
    }

    @Override
    public void deletePanel(int id) {
        rightSidebarDao.deletePanel(id);
    }
}
