package sql

class Product {
    String id
    String name
    String category
    BigDecimal price
}

interface ProducrDao {
    List<Product> getAllProducts()
    Product findById(String id)
    void insertProduct(Product product)
    void deleteProduct(String id)
}

import groovy.sql.Sql

@Singleton
class GroovyProdactDao implements ProducrDao {

    static Sql sql = Sql.newInstance(
            url: 'jdbc:h2:./db/productdb', driver: 'org.h2.Driver'
    )

    static {
        sql.execute 'DROP TABLE IF EXISTS product'

        sql.execute '''
            CREATE TABLE product (
                id INT PRIMARY KEY,
                name VARCHAR(25),
                price DOUBLE
            );
        '''

        sql.execute """
            INSERT INTO product VALUES
                (1, 'baseball', 4.99)
                (2, 'football', 14.95)
                (3, 'basketball', 4.99)
        """
    }

    //@Override
    List<Product> getAllProducts() {
        String sqlText = 'select * from product'
        sql.rows(sqlText).collect { row ->
            new Product(id: row.id, name: row.name, price: row.price)
        }
        //return null
    }

    //@Override
    Product findById(String id) {
        String sqlText = 'select * from product where id=?'
        def row = sql.firstRow(sqlText, [id])
        row ? new Product(id: row.id, name: row.name, price: row.price) : null
        //return null
    }

    //@Override
    void insertProduct(Product product) {
        String sqlText = 'insert into product(id, name, price) values(?, ?, ?)'
        sql.executeInsert sqlText, [product.id, product.name, product.price]
    }

    //@Override
    void deleteProduct(String id) {
        String sqlText = 'delete from product where id=?'
        sql.executeUpdate(sqlText, [id])
    }
}