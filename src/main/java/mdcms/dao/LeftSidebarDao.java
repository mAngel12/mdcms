package mdcms.dao;

import mdcms.model.LeftSidebar;

import java.util.List;

public interface  LeftSidebarDao {

    void addPanel(LeftSidebar panel);

    List<LeftSidebar> getPanels();

    LeftSidebar getPanel(int id);

    void deletePanel(int id);
}
