package firstideademo.repository;

import firstideademo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * [@link User] [@link Repository]
 */
@Repository
public class UserRepository {

    private final ConcurrentHashMap<Integer, User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * 保存用户对象
     * @param user [User]对象
     * @return 如果保存成功，返回true
     * 否则 返回false
     */
    public boolean save(User user) {
        //从1开始自增
        Integer id = idGenerator.incrementAndGet();
        user.setId(id.toString());

        return repository.put(id,user) == null;
    }

}
