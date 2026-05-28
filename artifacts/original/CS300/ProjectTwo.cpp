#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

// Course structure
struct Course {
    string courseNumber;
    string courseTitle;
    vector<string> prerequisites;
};

// Tree node structure
struct Node {
    Course course;
    Node* left;
    Node* right;

    Node(Course c) {
        course = c;
        left = nullptr;
        right = nullptr;
    }
};

// Binary Search Tree class
class CourseBST {
private:
    Node* root;

    void insertNode(Node*& node, Course course) {
        if (node == nullptr) {
            node = new Node(course);
        } else if (course.courseNumber < node->course.courseNumber) {
            insertNode(node->left, course);
        } else {
            insertNode(node->right, course);
        }
    }

    void inOrder(Node* node) {
        if (node != nullptr) {
            inOrder(node->left);
            cout << node->course.courseNumber << ": " << node->course.courseTitle << endl;
            inOrder(node->right);
        }
    }

    Node* search(Node* node, string courseNumber) {
        if (node == nullptr || node->course.courseNumber == courseNumber) {
            return node;
        } else if (courseNumber < node->course.courseNumber) {
            return search(node->left, courseNumber);
        } else {
            return search(node->right, courseNumber);
        }
    }

public:
    CourseBST() {
        root = nullptr;
    }

    void insert(Course course) {
        insertNode(root, course);
    }

    void printInOrder() {
        inOrder(root);
    }

    Course* findCourse(string courseNumber) {
        Node* found = search(root, courseNumber);
        if (found != nullptr) {
            return &found->course;
        }
        return nullptr;
    }
};

// Global instance of the tree
CourseBST courseTree;

// Function to load courses from file
void loadCourses(string fileName) {
    ifstream file(fileName);
    string line;

    if (!file.is_open()) {
        cout << "Error: Unable to open file." << endl;
        return;
    }

    while (getline(file, line)) {
        stringstream ss(line);
        string courseNum, title, prereq;
        Course course;

        getline(ss, courseNum, ',');
        getline(ss, title, ',');

        course.courseNumber = courseNum;
        course.courseTitle = title;

        while (getline(ss, prereq, ',')) {
            course.prerequisites.push_back(prereq);
        }

        courseTree.insert(course);
    }

    file.close();
    cout << "Courses loaded successfully!" << endl;
}

// Function to display menu
void displayMenu() {
    cout << "\n====== ABCU Advising Program ======" << endl;
    cout << "1. Load Data Structure" << endl;
    cout << "2. Print Course List" << endl;
    cout << "3. Print Course" << endl;
    cout << "9. Exit" << endl;
    cout << "Enter option: ";
}

// Function to print course details
void printCourseDetails(Course* course) {
    if (course == nullptr) {
        cout << "Course not found." << endl;
        return;
    }

    cout << course->courseNumber << ": " << course->courseTitle << endl;
    if (!course->prerequisites.empty()) {
        cout << "Prerequisites: ";
        for (size_t i = 0; i < course->prerequisites.size(); ++i) {
            cout << course->prerequisites[i];
            if (i < course->prerequisites.size() - 1) cout << ", ";
        }
        cout << endl;
    } else {
        cout << "No prerequisites." << endl;
    }
}

int main() {
    int choice;
    string fileName;
    string searchCourse;

    do {
        displayMenu();
        cin >> choice;

        switch (choice) {
            case 1:
                cout << "Enter file name: ";
                cin >> fileName;
                loadCourses(fileName);
                break;
            case 2:
                cout << "\nCourse List:" << endl;
                courseTree.printInOrder();
                break;
            case 3:
                cout << "Enter course number: ";
                cin >> searchCourse;
                printCourseDetails(courseTree.findCourse(searchCourse));
                break;
            case 9:
                cout << "Exiting program..." << endl;
                break;
            default:
                cout << "Invalid option. Please try again." << endl;
        }

    } while (choice != 9);

    return 0;
}
