package mdcms.service;

import mdcms.dao.PageDao;
import mdcms.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("pageService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PageServiceImpl implements PageService {

    @Autowired
    private PageDao pageDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addPage(Page page) {
        pageDao.addPage(page);
    }

    @Override
    public List<Page> getPages() {
        return pageDao.getPages();
    }

    @Override
    public Page getPageByAddressId(String addressId) {
        return pageDao.getPageByAddressId(addressId);
    }

    @Override
    public Page getPageById(int id) {
        return pageDao.getPageById(id);
    }

    @Override
    public void deletePageByAddressId(String addressId) {
        pageDao.deletePageByAddressId(addressId);
    }

    @Override
    public void deletePageById(int id) {
        pageDao.deletePageById(id);
    }

    public boolean isAddressIdUnique(Integer id, String addressId) {
        Page page = getPageByAddressId(addressId);
        return ( page == null || ((id != null) && (page.getId() == id)));
    }
}
