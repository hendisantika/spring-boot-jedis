# Spring Boot Redis Cache DB Operation using Jedis Java Client

### Things todo list

In this Demo, I have shown with the help of Jedis client and Spring Redis data how we can put data in Redis DataBase (
SpringBoot App)

#Spring Boot Application with Redis as Database and Cache ( Also used Spring Data Redis ) Redis is an open source
powerful
and high performance in-memory data structure store, used as a database, cache and message broker It supports data
structures such as strings, hashes, lists, sets, sorted sets, etc. It's Key-Value Pair NoSql Database.

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-jedis.git`
2. Navigate to the folder: `cd spring-boot-jedis`
3. Run the application: `mvn clean spring-boot:run`

What is caching? Caching is a mechanism to enhance the performance of a system. It is a temporary memory that lies
between
the application and the persistent database. Cache memory stores recently used data items in order to reduce the number
of database hits as much as possible.

Why we need caching? Caching of frequently used data in application is a very popular technique to increase performance
of application. With caching, we store such frequently accessed data in memory to avoid hitting the costly backends
every time when user requests the data. Data access from memory is always faster in comparison to fetching from storage
like database, file system or other service calls.

What data should be cached? This is mostly opinionated decision about the type of data which should reside in cache
and go through cache lifecycle. It varies in different scenario and requirement on how much time we can tolerate
stale data. So caching candidates will vary on each project, still those are few examples of caching – List of products
available in an eCommerce store Any Master data which is not frequently changed Any frequently used database read query,
where result does not change in each call at least for a specific period.
