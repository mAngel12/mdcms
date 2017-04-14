package mdcms.service;

import mdcms.dao.GalleryDao;
import mdcms.model.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("galleryService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryDao galleryDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addImage(Gallery image) {
        galleryDao.addImage(image);
    }

    @Override
    public List<Gallery> getGallery() {
        return galleryDao.getGallery();
    }

    @Override
    public Gallery getImage(int id) {
        return galleryDao.getImage(id);
    }

    @Override
    public void deleteImage(int id) {
        galleryDao.deleteImage(id);
    }
}
