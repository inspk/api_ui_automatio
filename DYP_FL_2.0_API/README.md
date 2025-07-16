# DYP FL 2.0 API Automation Framework

## Overview
This is a comprehensive API automation framework for the DYP FL 2.0 system, built with Java, TestNG, RestAssured, and ExtentReports. The framework supports multiple user roles (Internal User and Provider User) and provides pod-wise test organization.

## Framework Architecture

### Core Components
- **BaseTest**: Central test base class with authentication and configuration management
- **AuthUtil**: Handles authentication token management for both user types
- **TestDataUtil**: Manages test data loading from JSON files
- **ExtentReportManager**: Generates comprehensive test reports
- **ResponseLoggingFilter**: Logs API request/response details

### Project Structure
```
DYP_FL_2.0_API/
├── src/
│   ├── main/java/com/dyp/base/
│   │   ├── BaseTest.java              # Core test base class
│   │   ├── AuthUtil.java              # Authentication utilities
│   │   ├── TestDataUtil.java          # Test data management
│   │   ├── ExtentReportManager.java   # Report generation
│   │   ├── ResponseLoggingFilter.java # API logging
│   │   └── ExtentTestListener.java    # TestNG listener
│   └── test/java/
│       ├── POD2_ProviderDataPU/       # Provider User tests
│       ├── POD3_ProviderDataIU/       # Internal User tests
│       └── POD4_SystemConfiguration/  # System config tests
├── testdata/
│   ├── POD2_ProviderDataPU_testdata.json
│   ├── POD3_ProviderDataIU_testdata.json
│   └── POD4_SystemConfiguration_testdata.json
├── src/test/resources/config/
│   └── base_config.properties         # Configuration file
└── testng.xml                        # TestNG suite configuration
```

## Authentication Flow

### Global Authentication Process
1. **@BeforeSuite**: Initialize configuration and fetch authentication tokens
2. **@BeforeMethod**: Validate tokens before each test method
3. **@AfterMethod**: Clear tokens after each test method

### Token Management
- **Internal User Token**: Fetched using internal user credentials
- **Provider User Token**: Fetched using provider user credentials with fallback to internal user
- **Token Validation**: JWT token validation with expiry checking
- **Token Refresh**: Automatic token refresh when expired

### User Roles
- **Internal User (IU)**: System administrators and internal staff
- **Provider User (PU)**: Healthcare providers and external users

## Test Organization

### POD Structure
- **POD1_Enrollments**: Enrollment-related APIs (ready for implementation)
- **POD2_ProviderDataPU**: Provider User APIs (`/api/provider-api/v1`)
- **POD3_ProviderDataIU**: Internal User APIs (`/api/internal-user-api/v1`)
- **POD4_SystemConfiguration**: System configuration APIs (`/api/system-configuration/v1`)

### Test Categories
Each POD contains:
- **Valid Tests**: Positive test scenarios
- **Invalid Tests**: Negative test scenarios

## Configuration Management

### Environment Support
- **dev01**: Development environment
- **dev02**: Development environment 2
- **qa**: Quality Assurance environment

### Configuration File
Located at: `src/test/resources/config/base_config.properties`

```properties
# Environment Configuration
environment=dev01

# Environment URLs
dev01.baseUrl=https://dyp2-sb-dev01.hhstechgroup.com

# User Credentials
dev01.internalUserEmail=internal.user.dyp+cd@gmail.com
dev01.internalUserPassword=Internaluser1!
dev01.providerUserEmail=internal.user.dyp+cd@gmail.com
dev01.providerUserPassword=Internaluser1!

# Auth endpoint
loginEndpoint=/api/providermgmt/authenticate/login
```

## Test Data Management

### JSON Test Data Structure
```json
{
  "apiName": {
    "feature": "API Feature Name",
    "description": "API Description",
    "valid": {
      "field1": "value1",
      "field2": "value2"
    },
    "invalid": {
      "field1": "invalid_value",
      "field2": ""
    }
  }
}
```

### Test Data Loading
- **Pod-wise**: Each POD loads its specific JSON file
- **Dynamic**: Test data is loaded at runtime
- **Validation**: JSON structure is validated before test execution

## Running Tests

### Prerequisites
- Java 10 or higher
- Maven 3.6 or higher
- Internet connection for API access

### Maven Commands

#### Run All Tests
```bash
mvn clean test
```

#### Run Specific POD
```bash
mvn test -Dtest=POD2_ProviderDataPU
```

#### Run Specific Test Class
```bash
mvn test -Dtest=AllProviderStatusTest
```

#### Run with TestNG XML
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### TestNG Configuration
```xml
<?xml version="1.0" encoding="UTF-8"?>
<suite name="DYP_FL_2.0 Suite">
    <listeners>
        <listener class-name="com.dyp.base.ExtentTestListener"/>
    </listeners>
    
    <test name="POD2_ProviderDataPU">
        <packages>
            <package name="POD2_ProviderDataPU.valid"/>
            <package name="POD2_ProviderDataPU.invalid"/>
        </packages>
    </test>
</suite>
```

## Test Reports

### ExtentReports
- **Location**: `test-output/reports/YYYY-MM-DD/`
- **Format**: HTML reports with detailed test information
- **Features**: 
  - Test execution timeline
  - API request/response logging
  - Screenshot support
  - Environment information

### Report Features
- **Test Summary**: Pass/fail statistics
- **API Details**: Request/response logging
- **Environment Info**: System and test environment details
- **Screenshots**: Visual test evidence (for UI tests)

## Framework Features

### High-Level Design
- **Clean Architecture**: Separation of concerns
- **Minimal Logging**: Reduced console output for clarity
- **Global Token Management**: Centralized authentication
- **Pod-wise Organization**: Logical test grouping
- **Data-Driven**: JSON-based test data

### Authentication Features
- **Automatic Token Fetching**: Tokens fetched at suite start
- **Token Validation**: JWT token validation
- **Token Refresh**: Automatic refresh when expired
- **Fallback Mechanism**: Provider tests can use internal tokens
- **Token Cleanup**: Tokens cleared after each test

### Test Data Features
- **JSON-based**: Structured test data in JSON files
- **Pod-specific**: Each POD has its own test data file
- **Validation**: JSON structure validation
- **Dynamic Loading**: Test data loaded at runtime

### Reporting Features
- **ExtentReports**: Comprehensive HTML reports
- **API Logging**: Request/response details
- **Environment Info**: System and test environment
- **Test Timeline**: Execution timeline

## Best Practices

### Test Development
1. **Extend BaseTest**: All test classes should extend BaseTest
2. **Use @BeforeClass**: Call `setupPodTestData(podName)` in @BeforeClass
3. **Validate Test Data**: Call `validateTestData(apiName)` before test execution
4. **Use Helper Methods**: Use `getToken(userType)` for authentication
5. **Log Test Info**: Use `logTestInfo()`, `logTestPass()`, `logTestFail()` for logging

### Test Data Management
1. **JSON Structure**: Follow the standard JSON structure
2. **Valid/Invalid Data**: Include both valid and invalid test data
3. **Field Names**: Use descriptive field names
4. **Data Validation**: Validate test data before use

### Configuration Management
1. **Environment Variables**: Use environment-specific configuration
2. **Credentials**: Store credentials securely
3. **URLs**: Use environment-specific base URLs
4. **Endpoints**: Configure login endpoints per environment

## Troubleshooting

### Common Issues

#### Authentication Failures
- **Check Credentials**: Verify email/password in config
- **Check Network**: Ensure internet connectivity
- **Check Environment**: Verify environment configuration

#### Test Data Issues
- **JSON Format**: Check JSON syntax
- **File Path**: Verify test data file exists
- **Field Names**: Ensure field names match test code

#### API Failures
- **Token Issues**: Check token validation
- **Network Issues**: Verify API endpoint accessibility
- **Data Issues**: Verify test data is valid

### Debug Mode
To enable detailed logging, modify the logging configuration in the respective utility classes.

## Contributing

### Adding New Tests
1. Create test class extending BaseTest
2. Add test data to appropriate JSON file
3. Implement test methods following the standard pattern
4. Add test class to TestNG XML if needed

### Adding New PODs
1. Create POD directory structure
2. Add test data JSON file
3. Update TestNG XML configuration
4. Implement test classes

### Configuration Updates
1. Update `base_config.properties` for new environments
2. Add new credentials if needed
3. Update base URLs for new environments

## Version History

### v1.0-SNAPSHOT
- Initial framework setup
- Authentication system implementation
- Pod-wise test organization
- ExtentReports integration
- Test data management system

## Support

For framework support and questions, please refer to the project documentation or contact the development team. 