Chain of Responsibility pattern decouples the sender of a request from its receiver by giving multiple objects the chance to handle the request.

**Good for**
1. to decouple a sender of a request from the receivers and have these receivers separated into own entities
2. creating pipelines and handling events

**pitfalls**
1. implementation involving partial functions
2. affects readability