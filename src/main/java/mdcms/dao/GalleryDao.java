package mdcms.dao;


import mdcms.model.Gallery;

import java.util.List;

public interface GalleryDao {

    void addImage(Gallery image);

    List<Gallery> getGallery();

    Gallery getImage(int id);

    void deleteImage(int id);
}
