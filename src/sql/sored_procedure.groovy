package sql

import groovy.sql.Sql

int getFilmsInStock() {
    Sql sql = Sql.newInstance(
            url: 'jdbc:mysql://localhost:3306/sakila',
            driver: 'com.mysql.jdbc.Driver',
            user: 'root', password: ''
    )

    int result = 0;

    // Call stored procedure, return vars marked by Sql.TYPE, and returned by closure
    sql.call('{call film_in_stock(?, ?, ?)}', [filmId, storeId, Sql.INTEGER]) { count ->
        result = count
    }
    result
}

int films = getFilmsInStock(1,1)
println "For stor id 1, and film id 1, there are $films copies in stock"

// Implementation W\O side effects

class StoredProcedureService {
    static Sql = Sql.newInstance(
            url: 'jdbc:mysql://localhost:3306/sakila',
            driver: 'com.mysql.jdbc.Driver',
            user: 'root', password: ''
    )

    int getFilmsInStock(filmId, storeId) {
        int result =
        // Call stored procedure, return vars marked by Sql.TYPE, and returned by closure
        sql.call('{call film_in_stock(?, ?, ?)}', [filmId, storeId, Sql.INTEGER]) { count ->
            result = count
        }
        result
    }

    // overload method with closure as argumen W/O side effects
    void getFilmsInStock(filmId, storeId, closure) {
        sql.call('{call film_in_stock(?, ?, ?)}', [filmId, storeId, Sql.INTEGER], closure)
    }

}

