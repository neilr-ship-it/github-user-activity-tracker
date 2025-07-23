# GitHub User Activity Tracker

Track and filter recent GitHub user activity via the GitHub Events API using a Spring Boot backend.

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![REST API](https://img.shields.io/badge/API-RESTful-orange)
![GitHub API](https://img.shields.io/badge/GitHub-API-black)

## 🚀 Features

- ✅ Fetch recent GitHub events for any public username
- ✅ Supports event types: `PushEvent`, `IssuesEvent`, `PullRequestEvent`
- ✅ Extracts event type, repo name, timestamp, and relevant details
- ✅ Filter results by:
  - Repository name
  - Date range
  - Event type (coming soon!)
- 🛡️ Secures GitHub token using environment variables

---

## 📦 Tech Stack

- Java 17
- Spring Boot (Web, RestTemplate)
- GitHub REST API v3
- Maven

---

## 🛠️ Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/neilr-ship-it/github-user-activity-tracker.git
cd github-user-activity-tracker
