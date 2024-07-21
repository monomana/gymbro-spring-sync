**** Post usando curl

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"name":"test","duration_months":3,"price":5500.00}'  http://localhost:8080/membership-types
