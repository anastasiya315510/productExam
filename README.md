The API should expose Products in the system.
Each Product has 
- name
- description
- price
- discount (percents)
- discount name (i.e., “Summer Sale Discount”)

Products should be saved in the database.
Whenever requested via REST API, the response should fetch the data from the database and include Grand Total = price - discount

Clients Level
Expose API to create clients, i.e., “registration”
Clients get persisted to the database.
Each client has:
First name
Last name
Client type: REGULAR, SILVER, GOLDEN
Each client type has a different discount applied to each product.

Discounts are applied to products as following:
REGULAR 
doesn’t have any account specific discounts 
SILVER – has 5% discount
This client type’s discounts apply by “which discount is bigger”
If a product has discount of 10%, then a SILVER client gets 10% discount
If a product has discount less than 5%, then SILVER discount applies to the product price

GOLDEN – has 10% discount
	This client type’s discounts apply by “summing all available discounts”
	If a product has discount of 10%, then a GOLDEN client gets 20% 
(10% from product and 10% from account)

It is necessary to return “discount name” in response DTO.
If there is a Product discount ONLY -> then “discount name” from Products should be used.
If there are discounts from GOLDEN client and the Product –> both “discount names” should be concatenated 
(UI readable form, i.e. “Summer Sale Discount and GOLDEN Client discount”)

Products can be viewed “anonymously”, without clientId.
clientId should be passed in to “Authorization” header for each product request, in order to see client specific discounts.

The final Product DTO looks as follows:
Product name
Product description
Price
Total discount 
Discount name
Grand Total
Client (or null)
First name
Last name
clientId
client type

To use my program, you have to make post request for product
"http://localhost:8081/product"
set up Postman on  @RequestBody, JSON
with ProductDTO example

{
    "name":"lipstic",
    "description":"nice",
    "price":10,
    "discount":2,
    "discountName":"sale",
    "grandTotal":0
   
}
or ProductDTO with Client
{
    "name":"lipstic",
    "description":"nice",
    "price":10,
    "discount":1,
    "discountName":"sale",
    "grandTotal":0,
    "clientDTO":
    {
    "firstName":"Anna",
    "lastName":"Ivanova",
    "type":"GOLDEN"
}
to see the discount, please send GetRequest http://localhost:8081/discount
set up Postman on  @RequestBody, JSON
{
    "name":"lipstic",
    "description":"nice",
    "price":10,
    "discount":1,
    "discountName":"sale",
    "grandTotal":0,
    "clientDTO":
    {
    "firstName":"Anna",
    "lastName":"Ivanova",
    "type":"GOLDEN"
}
this will calculate the total of price agree Client Type and discount of product

