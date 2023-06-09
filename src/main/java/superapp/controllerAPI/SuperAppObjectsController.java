package superapp.controllerAPI;

import org.springframework.beans.factory.annotation.Autowired;
import superapp.bounderies.ObjectBoundary;
import superapp.bounderies.ObjectId;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import superapp.bounderies.UserBoundary;
import superapp.logic.ObjectsService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SuperAppObjectsController {

        private ObjectsService objectsService;
    @Autowired
    public void setObjectsService(ObjectsService objectsService){
        this.objectsService = objectsService;
    }
        @RequestMapping(
                path = {"/superapp/objects"},
                method = {RequestMethod.POST},
                produces = {MediaType.APPLICATION_JSON_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE}
        )

        public ObjectBoundary createObject(@RequestBody ObjectBoundary input){
                return objectsService.CreateObject(input);
        }

        @RequestMapping(
                path = {"/superapp/objects/{superapp}/{InternalObjectId}"},
                method = {RequestMethod.PUT},
                consumes = {MediaType.APPLICATION_JSON_VALUE}
        )
        public void updateObject ( @PathVariable("superapp") String superapp,
                                   @PathVariable("InternalObjectId") String InternalObjectId,
                                   @RequestBody ObjectBoundary input) throws Exception {
                objectsService.updateObject(superapp,InternalObjectId,input);
        }

        @RequestMapping(
                path = {"/superapp/objects/{superapp}/{InternalObjectId}"},
                method = {RequestMethod.GET},
                consumes = {MediaType.APPLICATION_JSON_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE})
        public ObjectBoundary retrieveObject(
                @PathVariable("superapp") String superapp,
                @PathVariable("InternalObjectId") String InternalObjectId) throws Exception {
                return objectsService.getSpecificObject(superapp,InternalObjectId).orElseThrow(()->new Exception("could not find message by id: " + InternalObjectId)); //TODO: Change to custom exception
        }

        @RequestMapping(
                path = {"/superapp/objects"},
                method = {RequestMethod.GET},
                consumes = {MediaType.APPLICATION_JSON_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE})
        public ObjectBoundary[] getAllObjects (){
            List<ObjectBoundary> allObjects = objectsService.getAllObjects();
            return allObjects.toArray(new ObjectBoundary[0]);

        }


    }