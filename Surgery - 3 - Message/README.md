# 'Surgery'
This was written at the end of a lecture by Dr Jon Robinson.
----
The idea of this program was a potential solution for how to structure the messages between the applications (the initiator, load balancer and node(s)). They would sent essentially CSV strings between one another and upon receiving a message split by the comma. Each message type (in this example STORE and PRINT) would be determined from the first element in the split array. The rest of the arguments were then determined on the type of message received based on their position in the split array.