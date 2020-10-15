Runtime Analysis:

Iterating over all of the participants as you find a reciever for each one will mean the runtime is atleast O(n). Building the possibleReceivers list O(n-1) so the runtime will be O(n^2). Because a random number generator is used there is a possibility that it will create circular givers and receivers. Therefore, I re-try 3 times.  There is a possibility that there are no valid options in the family scenario. The code to handle the retries wasn't added until part 2 when I discovered the problem via unit testing part 2.

The runtime in total would really be 3*O(n^2). 
