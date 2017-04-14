package mdcms.service;

import mdcms.model.Page;

import java.util.List;

public interface PageService {

    void addPage(Page page);

    List<Page> getPages();

    Page getPageByAddressId(String addressId);

    Page getPageById(int id);

    void deletePageByAddressId(String addressId);

    void deletePageById(int id);

    boolean isAddressIdUnique(Integer id, String addressId);

}
