package repository.impl;

import entity.FileInfo;
import org.hibernate.Session;
import repository.FileRepository;

import java.util.List;

public class FileRepositoryImpl implements FileRepository {

    @Override
    public FileInfo getById(Long aLong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        FileInfo fileInfo = session.get(FileInfo.class, aLong);
        session.getTransaction().commit();
        session.close();
        return fileInfo;
    }

    @Override
    public List<FileInfo> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<FileInfo> fileInfos = session.createQuery("FROM FileInfo").list();
        session.getTransaction().commit();
        session.close();
        return fileInfos;
    }

    @Override
    public FileInfo update(FileInfo fileInfo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        FileInfo fileInfo1 = session.get(FileInfo.class, fileInfo.getId());
        fileInfo1.setPathFile(fileInfo.getPathFile());
        session.update(fileInfo1);
        session.getTransaction().commit();
        session.close();
        return fileInfo1;
    }

    @Override
    public boolean deleteById(Long aLong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        FileInfo fileInfo = session.get(FileInfo.class, aLong);
        session.delete(fileInfo);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public FileInfo save(FileInfo fileInfo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.saveOrUpdate(fileInfo);
        session.getTransaction().commit();
        session.close();
        return fileInfo;
    }
}
