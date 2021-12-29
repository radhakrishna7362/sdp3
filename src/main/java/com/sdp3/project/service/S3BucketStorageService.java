package com.sdp3.project.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//import com.amazonaws.AmazonClientException;
//import com.amazonaws.AmazonServiceException;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.ListObjectsRequest;
//import com.amazonaws.services.s3.model.ObjectListing;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.S3ObjectSummary;

@Service
public class S3BucketStorageService {

    /*
    private Logger logger = LoggerFactory.getLogger(S3BucketStorageService.class);

    @Autowired
    private AmazonS3 amazonS3Client;

    @Value("${application.bucket.name}")
    private String bucketName;

    public String uploadFile(String keyName, MultipartFile file) {
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            amazonS3Client.putObject(bucketName, keyName, file.getInputStream(), metadata);
            return "File uploaded: " + keyName;
        } catch (IOException ioe) {
            logger.error("IOException: " + ioe.getMessage());
        } catch (AmazonServiceException serviceException) {
            logger.info("AmazonServiceException: "+ serviceException.getMessage());
            throw serviceException;
        } catch (AmazonClientException clientException) {
            logger.info("AmazonClientException Message: " + clientException.getMessage());
            throw clientException;
        }
        return "File not uploaded: " + keyName;
    }
    
    public List<String> listFiles() {
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest().withBucketName(bucketName);
        List<String> keys = new ArrayList<>();
        ObjectListing objects = amazonS3Client.listObjects(listObjectsRequest);
        while (true) {
            List<S3ObjectSummary> objectSummaries = objects.getObjectSummaries();
            if (objectSummaries.size() < 1) {
                break;
            }
            for (S3ObjectSummary item : objectSummaries) {
                if (!item.getKey().endsWith("/"))
                    keys.add(item.getKey());
            }
            objects = amazonS3Client.listNextBatchOfObjects(objects);
        }
        return keys;
    }
    */

}