

This program is for creating an IndexTree, a special type of Binary Search Tree. The IndexTree does a bit more than your standard tree, as we will use it to build an index of a file.
This will be much like the index you find at the end of a textbook, where each topic is listed in alphabetical order with the pages it is found on. 
Since files don’t have traditional pages to work off of, we will instead use line numbers. Furthermore, rather than building an index of only a few select topics, we will build an index over all the words in the file.

To do this, we use a special type of node. The IndexTree is made up of special IndexNodes. Rather than using generics, each IndexNode stores a word, the count of occurrences of that word, and a list of all lines that word appeared on (this means that each IndexNode will hold their own list). 
Nodes in the tree will be sorted by the String. Use an IndexTree object to store an index of all the words that are in the provided text file, then display the index by performing an inorder traversal of the tree.


