package mdcms.dao;

import mdcms.model.Page;

import java.util.List;

public interface PageDao {

    void addPage(Page page);

    List<Page> getPages();

    Page getPageById(int id);

    Page getPageByAddressId(String addressId);

    void deletePageByAddressId(String addressId);

    void deletePageById(int id);
}