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
#  How to Run
