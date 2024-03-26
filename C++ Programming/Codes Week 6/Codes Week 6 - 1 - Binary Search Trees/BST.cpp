// Kode C++ untuk Binary Tree
#include <stdlib.h>
#include <iostream>

using namespace std;

struct node {
  int data;
  struct node *kiri;
  struct node *kanan;
};

// Untuk membuat Node Baru
struct node *nodeBaru(int data) {
  struct node *node = (struct node *)malloc(sizeof(struct node));

  node->data = data;

  node->kiri = NULL;
  node->kanan = NULL;
  return (node);
}

// Traverse Preorder
void traversePreOrder(struct node *temp) {
  if (temp != NULL) {
    cout << " " << temp->data;
    traversePreOrder(temp->kiri);
    traversePreOrder(temp->kanan);
  }
}

// Traverse Inorder
void traverseInOrder(struct node *temp) {
  if (temp != NULL) {
    traverseInOrder(temp->kiri);
    cout << " " << temp->data;
    traverseInOrder(temp->kanan);
  }
}

// Traverse Postorder
void traversePostOrder(struct node *temp) {
  if (temp != NULL) {
    traversePostOrder(temp->kiri);
    traversePostOrder(temp->kanan);
    cout << " " << temp->data;
  }
}

int main() {
  // Inisiasi Pohon Tree 
  struct node *root = nodeBaru(1);
  root->kiri = nodeBaru(2);
  root->kanan = nodeBaru(3);
  root->kiri->kiri = nodeBaru(4);

  cout << "preorder traversal: "; // Yang akan melintasi dari root ke subtree kiri lalu ke subtree kanan.
  traversePreOrder(root);
  cout << "\nInorder traversal: "; //  Yang akan melintasi dari root ke subtree kiri lalu ke subtree kanan.
  traverseInOrder(root);
  cout << "\nPostorder traversal: "; // Yang akan melintasi dari subtree kiri ke subtree kanan kemudian ke root.
  traversePostOrder(root);
}