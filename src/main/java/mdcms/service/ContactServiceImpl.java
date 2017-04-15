package mdcms.service;

import mdcms.dao.ContactDao;
import mdcms.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("contactService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addContactPost(Contact contact) {
        contactDao.addContactPost(contact);
    }

    @Override
    public List<Contact> getContactPosts() {
        return contactDao.getContactPosts();
    }

    @Override
    public List<Contact> getContactPostsNotReaded() {
        return contactDao.getContactPostsNotReaded();
    }

    @Override
    public List<Contact> getContactPostsReaded() {
        return contactDao.getContactPostsReaded();
    }

    @Override
    public Contact getContactPost(int id) {
        return contactDao.getContactPost(id);
    }

    @Override
    public void readContactPost(int id) {
        contactDao.readContactPost(id);
    }

    @Override
    public void notReadContactPost(int id) {
        contactDao.notReadContactPost(id);
    }

    @Override
    public void deleteContactPost(int id) {
        contactDao.deleteContactPost(id);
    }
}
