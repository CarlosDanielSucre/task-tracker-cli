# Task Tracker CLI

**Task Tracker CLI** is a simple Java-based command-line application to manage your personal task list. You can add, update, delete, and mark tasks as done or in progress — all from your terminal. Tasks are stored in a local JSON file to persist data between sessions.

---

##  Features

-  Add a new task
- Update an existing task
- Delete a task
-  Mark a task as *in progress*
- Mark a task as *done*
- List all tasks
- Filter tasks by status (`todo`, `in-progress`, `done`)

---

## Task Structure

Each task is saved in `tasks.json` with the following fields:

```json
{
  "id": 1,
  "description": "Study Java",
  "status": "todo",
  "createdAt": "2025-07-27 18:01:48",
  "updatedAt": "2025-07-27 18:01:48"
}
```
# Project Challenge
This project was developed as part of the Task Tracker Challenge from roadmap.sh, a platform that provides real-world project ideas to practice and strengthen software development skills.

> 🧩 Challenge Source: [roadmap.sh/projects/task-tracker](https://roadmap.sh/projects/task-tracker)
> Challenge submited: [submited](https://roadmap.sh/projects/task-tracker/solutions?u=6874d3c83ed27010bd3450a1)

#  How to Run

1. Clone the repository
```
git clone https://github.com/your-username/task-tracker-cli.git
cd task-tracker-cli
```
3. Compile the source files
   
Make sure you’re inside the folder containing all `.java` files, then run:

```bash
javac TaskTracker.java TaskRepository.java Task.java
```

3. Use the CLI
Run commands using:
```bash
java TaskTracker <command> [arguments...]
```

### 🛠️ Available Commands
- ➕ Add a new task
```bash
java TaskTracker add "Buy groceries"
```
Output: Task added successfully (ID: 1)

- ✏️ Update an existing task
```bash
java TaskTracker update 1 "Buy groceries and cook dinner"
```
- ❌ Delete a task
```bash
java TaskTracker delete 1
```
- 🚧 Mark task as in progress
```bash
java TaskTracker mark-in-progress 1
```
- ✅ Mark task as done
```bash
java TaskTracker mark-done 1
```
- 📋 List all tasks
```bash
java TaskTracker list
```
- 🔍 List tasks by status
```bash
java TaskTracker list todo
java TaskTracker list in-progress
java TaskTracker list done
```
- ❓ Show help
```bash
java TaskTracker help
```
Displays a summary of available commands.

### 📁 Data Storage
All tasks are stored in a local tasks.json file located in the same directory as the app. The file will be created automatically on first run if it does not exist.

#### Requirements
Java 17 or higher

Terminal (Git Bash, CMD, PowerShell, etc.)

### Notes
This project does not use any external libraries or frameworks — only pure Java.
Tasks are handled in three classes: Task, TaskRepository, and TaskTracker.
Task IDs are automatically generated.
The CLI is case-sensitive (e.g., add ≠ Add).

### Author
Made with love by Carlos Daniel Sucre Cordova
✉️ carlosdanielsucre568@gmail.com

#### 📝 License
This project is open for learning and demonstration purposes. Feel free to use and modify.
