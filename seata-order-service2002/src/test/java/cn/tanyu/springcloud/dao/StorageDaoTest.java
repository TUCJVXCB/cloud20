package cn.tanyu.springcloud.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StorageDaoTest {

    @Autowired
    private StorageDao storageDao;

    @Test
    void decrease() {
        storageDao.decrease(1L, 10);
    }
}
