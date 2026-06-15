#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

struct Course {
    string courseNumber;
    string courseTitle;
    vector<string> prerequisites;
};

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

    void inOrder(Node* node, vector<Course>& sortedCourses) {
        if (node == nullptr) return;
        inOrder(node->left, sortedCourses);
        sortedCourses.push_back(node->course);
        inOrder(node->right, sortedCourses);
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

    void searchByPrefix(Node* node, const string& prefix, vector<Course>& results) {
        if (node == nullptr) return;
        searchByPrefix(node->left, prefix, results);
        if (node->course.courseNumber.rfind(prefix, 0) == 0) {
            results.push_back(node->course);
        }
        searchByPrefix(node->right, prefix, results);
    }

public:
    CourseBST() {
        root = nullptr;
    }

    void insert(Course course) {
        insertNode(root, course);
    }

    vector<Course> getSortedCourses() {
        vector<Course> sortedCourses;
        inOrder(root, sortedCourses);
        return sortedCourses;
    }

    Course* findCourse(string courseNumber) {
        Node* found = search(root, courseNumber);
        if (found != nullptr) {
            return &found->course;
        }
        return nullptr;
    }

    vector<Course> searchByPrefix(const string& prefix) {
        vector<Course> results;
        searchByPrefix(root, prefix, results);
        return results;
    }
};

CourseBST courseTree;

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

void displayMenu() {
    cout << "\n====== ABCU Advising Program ======" << endl;
    cout << "1. Load Data Structure" << endl;
    cout << "2. Print Course List" << endl;
    cout << "3. Print Course" << endl;
    cout << "4. Search Courses by Prefix" << endl;
    cout << "9. Exit" << endl;
    cout << "Enter option: ";
}

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

            case 2: {
                vector<Course> sorted = courseTree.getSortedCourses();
                cout << "\nCourse List:" << endl;
                for (auto& c : sorted) {
                    cout << c.courseNumber << ": " << c.courseTitle << endl;
                }
                break;
            }

            case 3:
                cout << "Enter course number: ";
                cin >> searchCourse;
                printCourseDetails(courseTree.findCourse(searchCourse));
                break;

            case 4: {
                cout << "Enter prefix: ";
                string prefix;
                cin >> prefix;

                vector<Course> matches = courseTree.searchByPrefix(prefix);

                if (matches.empty()) {
                    cout << "No courses found with prefix " << prefix << endl;
                } else {
                    cout << "\nCourses matching prefix '" << prefix << "':\n";
                    for (auto& c : matches) {
                        cout << c.courseNumber << ": " << c.courseTitle << endl;
                    }
                }
                break;
            }

            case 9:
                cout << "Exiting program..." << endl;
                break;

            default:
                cout << "Invalid option. Please try again." << endl;
        }

    } while (choice != 9);

    return 0;
}
