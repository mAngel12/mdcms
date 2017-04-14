package mdcms.dao;

import mdcms.model.RightSidebar;

import java.util.List;

public interface RightSidebarDao {

    void addPanel(RightSidebar panel);

    List<RightSidebar> getPanels();

    RightSidebar getPanel(int id);

    void deletePanel(int id);
}
