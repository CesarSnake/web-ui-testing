@UploadAndDownload
Feature: Upload and Download element of a webpage

  Scenario: Download
    Given I go to Upload and Download webpage
    Then I take a upload-download page screenshot with fileName "downloadStart"
    When I click the upload-download webpage button "downloadButton"
    And I wait a "1" seconds
    Then I check it has download the file "sampleFile.jpeg"
    And I take a upload-download page screenshot with fileName "downloadEnd"
    And I quit the Upload-Download webpage

  Scenario: Upload
    Given I go to Upload and Download webpage
    Then I take a upload-download page screenshot with fileName "uploadStart"
    When I upload a file using the upload-download input "uploadFile"
    Then I check the file has uploaded
    And I take a upload-download page screenshot with fileName "uploadEnd"
    And I quit the Upload-Download webpage