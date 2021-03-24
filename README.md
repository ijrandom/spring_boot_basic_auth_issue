# spring_boot_basic_auth_issue
Demonstrates basic auth performance issue in the latest (2.4.4) spring boot

```shell script
# start applicaion
/gradlew bootRun

# observe that each request take about 100ms
time curl -H 'Authorization: Basic dXNlcjpwYXNzd29yZA==' http://localhost:8080/private/hello
```

Uncomment password encoder configuration in WebSecurityConfig.java
Run same check again. 100ms delay gone