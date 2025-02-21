# Hotel-Selection-Agent-using-JADE

This project implements a **multi-agent system (MAS) using JADE** to automate hotel selection from various hotel websites. The system extracts hotel data (including customer reviews and ratings) from HTML pages and evaluates them to determine the **best hotel based on customer feedback**.

## Features
- **Web Scraping & Data Extraction**: Parses hotel listings and reviews from different booking websites.
- **JADE Agents**:
  - **Site Agents**: Collect hotel data from individual websites.
  - **Evaluation Agent**: Analyzes and ranks hotels based on customer reviews and ratings.
  - **Selection Agent**: Determines the best hotel among all candidates.
- **Intelligent Decision-Making**: Uses sentiment analysis or rating aggregation to ensure optimal hotel selection.

## Technologies Used
- **JADE (Java Agent DEvelopment Framework)** for multi-agent communication.
- **HTML Parsing** to extract hotel information.
- **Java/Python Integration (optional)** for advanced analysis.

## Installation & Usage
### Prerequisites
- Java (JDK 8 or later)
- JADE Framework
- Jsoup (for HTML parsing)

### Steps to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/hotel-selection-agent.git
   ```
2. Navigate to the project directory:
   ```bash
   cd hotel-selection-agent
   ```
3. Compile the Java files:
   ```bash
   javac -cp jade.jar:. src/*.java
   ```
4. Run the JADE platform:
   ```bash
   java -cp jade.jar:. jade.Boot -gui
   ```
5. Start the agents:
   ```bash
   java -cp jade.jar:. src.MainAgent
   ```

## Future Enhancements
- Support for real-time updates
- API integration with hotel booking platforms
- Advanced sentiment analysis for review evaluation

## License
This project is licensed under the MIT License.

## Contact
For any questions or contributions, please contact [your email or GitHub profile].
