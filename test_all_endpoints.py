#!/usr/bin/env python3
import requests

endpoints = {
    "PHP": "http://localhost:8011",
    "CGI": "http://localhost:8010/index.html",
    "JS": "http://localhost:8012",
    "JAVA": "http://localhost:8013",
    "ASP": "http://localhost:8014"
}

for name, url in endpoints.items():
    try:
        response = requests.get(url, timeout=5)
        print(f"[{name}] {url} - STATUS: {response.status_code}")
    except Exception as e:
        print(f"[{name}] {url} - ERROR: {e}")
