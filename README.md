# FlexiColumn Classifier

**FlexiColumn Classifier** is a flexible data classification tool that reads an Excel sheet, processes the selected column, and classifies the data using an external API (e.g., Google Gemini). The classification results are written into a new column in the same Excel sheet. It is highly adaptable and can be used in various industries such as pharmaceuticals, finance, or logistics.

## Features

- Reads an Excel file and allows the user to select a column for data processing.
- Sends data to an external API (e.g., Google Gemini) for classification.
- Writes the classification result into a new column in the Excel sheet.
- Built using Java and Apache POI for Excel operations.
- Maven is used as the build automation tool.

## Technologies

- **Java** - Main programming language
- **Apache POI** - To read and write Excel files
- **Google Gemini API** - For data classification
- **Maven** - Project build tool

## Prerequisites

Before you begin, ensure you have met the following requirements:

- You have installed Java 8 or higher.
- You have installed Maven.
- You have access to the Google Gemini API (or other APIs) and the necessary API keys.

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/FlexiColumn-Classifier.git
   ```

2. **Add your API key for Google Gemini:**

3. **Build the project using Maven:**

   ```bash
   mvn clean install
   ```

5. **Run the application:**

   ```bash
   mvn exec:java -Dexec.mainClass="com.example.Main"
   ```
