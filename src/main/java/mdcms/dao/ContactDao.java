package mdcms.dao;


import mdcms.model.Contact;

import java.util.List;

public interface ContactDao {

    void addContactPost(Contact contact);

    List<Contact> getContactPosts();

    List<Contact> getContactPostsNotReaded();

    List<Contact> getContactPostsReaded();

    Contact getContactPost(int id);

    void readContactPost(int id);

    void notReadContactPost(int id);

    void deleteContactPost(int id);

}
