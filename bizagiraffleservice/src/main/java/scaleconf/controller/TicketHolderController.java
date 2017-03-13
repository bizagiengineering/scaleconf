package scaleconf.controller;

import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import scaleconf.dao.Holder;
import scaleconf.dao.HolderDDBDao;
import scaleconf.dao.HolderDao;
import com.microsoft.azure.storage.*;
import scaleconf.model.CV;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by dev-camiloh on 3/6/17.
 */
@RestController
public class TicketHolderController {

    @RequestMapping("/api/holder")
    public Holder saveHolder() {
        HolderDao holderDao = new HolderDDBDao();
        Holder holder = new Holder("Camilo", "http://url", "http://document");
        holder = holderDao.createHolder(holder);
        return holder;
    }

    @PostMapping("/api/cv")
    public CV uploadCV(@RequestParam("cv") MultipartFile file) {
        String url = uploadFile(createContainer("DefaultEndpointsProtocol=http;AccountName=scaleconf;AccountKey=Zl9MhlM/iiAiyIKdvqJvX3x3tWIEM0P5VfxYqRuQJbgxM7JMFlYnvOqq0YoWHLMSdwC36R/ogbqwcsk36ajDEw=="), file);
        return new CV(url);
    }

    private CloudBlobContainer createContainer(String connection) {
        try {
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(connection);
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
            CloudBlobContainer container = blobClient.getContainerReference("scaleconf");
            container.createIfNotExists();
            return container;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String uploadFile(CloudBlobContainer container, MultipartFile file) {
        try {
            System.out.println(file.getOriginalFilename());
            CloudBlockBlob blob = container.getBlockBlobReference(file.getOriginalFilename());
            blob.upload(new ByteArrayInputStream(file.getBytes()), file.getSize());
            return blob.getUri().toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (StorageException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}