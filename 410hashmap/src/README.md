Basic Hash Map

You will write code that implements and exercises a basic Hash Map. The HashMap is a MAP ADT built on a hash table. We will do collision management in the hash table by chaining (hashing into lists, or buckets).

There are plenty of implementations of "hash" stuff out there. Please do not copy those. You may read them for ideas and understanding, but I want you to write your own code and follow the structure I outline below.

The heart of a hash table (and anything built on one, or using one) is a good hash function for the data type of the hashed keys. For basic learning, I encourage you to use the JavaScript code I posted (and demonstrated in class) to experiment with various hash function ideas (on String data); but for this assignment, you will use the hash function I supply below in the code template. It is the "pretty good string" function I showed and that your book says is similar to that used in Java.

There is a built-in hash function in Java but do not use it here. I want you to build your hash table with a hash function in it -- the specific function given here. Note that the hash function provided takes two parameters (String for key, and int for table array size); you will find that this second parameter will allow you to easily use the hash function to re-hash keys into a new table array when you double the table size (in the "extend" function). Details are below.

In our program, we will have one object (class) as "the HashMap". We will call the various MAP interface functions such as put, get, hasKey, extend, etc. on that object. The operations in a hash table (and so a HashMap) are best done iteratively, not recursively, since we are manipulating an array.

The Map Interface

As before, the code templates below contains two top level interfaces: Map, and HashMap. The Map interface is exactly the one we used in Assignment 2 (TreeMap). The difference here in Assignment 3 is that we are implementing the Map ADT using a hash table (rather than a BST). Since the Map interface is unchanged over Assignment 2, the functions are defined (as before) without reference to a hash table, an array, or any other implementation structure.

Using a Hash Table to build a Map

As noted, we will use a hash table to provide the various behavior characteristics of a Map ADT, including the requirement that keys stored are unique. We will see that a hash table gives us O(1) expected times for access operations (for put, get, hasKey); this speed comes at a cost in other areas... specifically you cannot do one of the things a TreeMap allows -- getting keys out in sorted order. Our HashMap will not give us sorted keys without doing an actual sorts (and bearing that cost). We still will provide a method to get all the keys, but the specs say the order of those keys in the returned array is "unspecified", meaning unpredictable (or "random" in the popular vernacular).

The HashMap Interface

The HashMap interface extends the Map interface and adds a few operations that are possible because the implementation method is a hash table. These include minKey, maxKey, and getKeys (in unspecified order). They also include operations reelated to the table itself: lambda (the ratio of elements stored to array slots); extend (double the size of the table array and rehash all the keys stored); and of course, hash (public access to the hash function itself).


