import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.apache.ivy.plugins.repository.Repository

import java.sql.ResultSet

public interface AccountDao {
    int createAccount(BigDecimal initialBalance);
    Account findAccountById(int id);
    List<Account> findAllAccounts();
    void updateAccount(Account account);
    void deleteAccount(int id);
}

@EqualsAndHashCode(includes = ['id'])
@ToString(includeNames = true )
class Account {
    Integer id
    BigDecimal balance

    def deposit(amount) {
        balance += amount
    }

    def withdraw(amount) {
        balance -= amount
    }
}

//@Repository
class JdbcAccountDao implements AccountDao {
    static int nextId = 3
    JdbcTemplate jdbcTemplate

    @Autowire JdbcAccountDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource)
    }

    int createAccount(BigDecimal initialBalance) {
        String sql = "insert into accounts(id, balance) values(?, ?)"
        int id = nextId++
        int uc = jdbcTemplate.update(sql, id, initialBalance)
        return id
    }

    Account findAccountById(int id) {
        String sql = "select * from accounts where id=?"
        jdbcTemplate.queryForObject(sql, accountMapper, id)
    }

    List<Account> findAllAccounts() {
        String sql = "select * from accounts"
        jdbcTemplate.query(sql, accountMapper)
    }

    void updateAccount(Account account) {
        String sql = "update accounts set balance=? where id=?"
        jdbcTemplate.update(sql, account.balance, account.id)
    }

    void deleteAccount(int id) {
        String sql = "delete from accounts where id=?"
        jdbcTemplate.update(sql, id)
    }

    def accountMapper = { ResultSet rs, int row ->
        new Account(id: rs.getInt('id'), balance: rs.getBigDecimal('balance')) as RowMapper<Account>
    }
}
