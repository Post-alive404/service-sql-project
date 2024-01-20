# Employees. Service.

## Description 
[`com.epam.rd.autocode.service.ServiceFactory`](src/main/java/com/epam/rd/autocode/service/ServiceFactory.java) method.

It should return an Employee service instance.



Services often performs as a layer between DAO and controllers as it is suggested by classical 3-layer architecture design.
Although main function of a Service is considered to be a provision of business logic so mature architecture approaches like Clean Architecture, DDD specifies that a Service should not depend on persistence layer. 



**Important**: Department object and injected Employee object referencing to his manager.
Object of a manager should be having injected Department as well, but his own manager should not be injected.
It is showing in graphical way:
```
employee
    |-department
    |-manager
        |-department
```

Though, implementation of `getWithDepartmentAndFullManagerChain` method requires extracting of an employee with full management chain 
meaning that it should have a manager who should have a manager who should have a manager and so on up to top manager.
So, it looks like:
```
employee
    |-department
    |-manager
        |-department
        |-manager
            |-department
            |-manager
                |-department
                |-manager
                    |-department
                    |-manager
                        ...
```


 