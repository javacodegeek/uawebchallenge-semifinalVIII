dataSource {
    pooled = true
    jmxExport = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
//    cache.region.factory_class = 'org.hibernate.cache.SingletonEhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}


// environment specific settings
environments {
    development {
        dataSource {
            driverClassName = "org.postgresql.Driver"
            dialect = "org.hibernate.dialect.PostgreSQLDialect"
            pooled = true
            type = "com.mchange.v2.c3p0.ComboPooledDataSource"
            properties {
                maxActive = -1
                minEvictableIdleTimeMillis=1800000
                timeBetweenEvictionRunsMillis=1800000
                numTestsPerEvictionRun=3
                testOnBorrow=true
                testWhileIdle=true
                testOnReturn=true
                validationQuery="SELECT 1"
            }
            username = 'postgres'
            password = '123'
            url = "jdbc:postgresql://localhost:5432/uwcua"
            dbCreate = "create-drop"
        }
    }
    heroku {
        dataSource {
            driverClassName = "org.postgresql.Driver"
            dialect = "org.hibernate.dialect.PostgreSQLDialect"
            pooled = true
            type = "com.mchange.v2.c3p0.ComboPooledDataSource"
            properties {
                maxActive = -1
                minEvictableIdleTimeMillis=1800000
                timeBetweenEvictionRunsMillis=1800000
                numTestsPerEvictionRun=3
                testOnBorrow=true
                testWhileIdle=true
                testOnReturn=true
                validationQuery="SELECT 1"
            }
            username = 'tzytpqwyizupdz'
            password = '1IR_RsvRpHejdvkT0ORXGsCPAt'
            url = "postgres://tzytpqwyizupdz:1IR_RsvRpHejdvkT0ORXGsCPAt@ec2-54-225-194-162.compute-1.amazonaws.com:5432/dcia6nepcslpg5"
            dbCreate = "create-drop"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    production {
        dataSource {
            driverClassName = "org.postgresql.Driver"
            dialect = "org.hibernate.dialect.PostgreSQLDialect"
            pooled = true
            type = "com.mchange.v2.c3p0.ComboPooledDataSource"
            properties {
                maxActive = -1
                minEvictableIdleTimeMillis=1800000
                timeBetweenEvictionRunsMillis=1800000
                numTestsPerEvictionRun=3
                testOnBorrow=true
                testWhileIdle=true
                testOnReturn=true
                validationQuery="SELECT 1"
            }
            username = 'tzytpqwyizupdz'
            password = '1IR_RsvRpHejdvkT0ORXGsCPAt'
            url = "postgres://tzytpqwyizupdz:1IR_RsvRpHejdvkT0ORXGsCPAt@ec2-54-225-194-162.compute-1.amazonaws.com:5432/dcia6nepcslpg5"
            dbCreate = "create-drop"
        }
    }
}
