package com.example.demo2;

import java.util.ArrayList;
import java.util.List;

public class PatientBST {
    public class Node {
        private Patient patient ;
        private Node left,right;
        public Node(Patient p){
            this.patient = p; 
            left = right = null;
        }
    }
    Node root ; 
    
    public PatientBST() {
        this.root = null;
    }

    public void insert(Patient patient) {
        root = insertRecursive(root, patient);
    }

    private Node insertRecursive(Node root, Patient patient) {
        if (root == null) {
            return new Node(patient);
        }

        if (patient.getPatientID().compareTo(root.patient.getPatientID()) < 0) {
            root.left = insertRecursive(root.left, patient);
        } else if (patient.getPatientID().compareTo(root.patient.getPatientID()) > 0) {
            root.right = insertRecursive(root.right, patient);
        }
        return root;
    }
    public Patient search(String patientID) {
        return searchRecursive(root, patientID);
    }

    private Patient searchRecursive(Node current, String patientID) {
        if (current == null) {
            return null;
        }
        if (patientID.equals(current.patient.getPatientID())) {
            return current.patient;
        }
        if (patientID.compareTo(current.patient.getPatientID()) < 0) {
            return searchRecursive(current.left, patientID);
        } else {
            return searchRecursive(current.right, patientID);
        }
    }
    
    public void delete(String patientID) {
        root = deleteRecursive(root, patientID);
    }

    private Node deleteRecursive(Node current, String patientID) {
        if (current == null) {
            return null;
        }
        if (patientID.equals(current.patient.getPatientID())) {
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {
                Patient smallestPatient = findSmallest(current.right);
                current.patient = smallestPatient;
                current.right = deleteRecursive(current.right, smallestPatient.getPatientID());
                return current;
            }
        }
        if (patientID.compareTo(current.patient.getPatientID()) < 0) {
            current.left = deleteRecursive(current.left, patientID);
        } else {
            current.right = deleteRecursive(current.right, patientID);
        }
        return current;
    }

    private Patient findSmallest(Node root) {
        return root.left == null ? root.patient : findSmallest(root.left);
    }

    public void displayInOrder() {
        displayInOrderRecursive(root);
    }

    private void displayInOrderRecursive(Node current) {
        if (current != null) {
            displayInOrderRecursive(current.left);
            current.patient.displayPatientInfo();
            displayInOrderRecursive(current.right);
        }
    
    }
    public List<Patient> getInOrderTraversal() {
        List<Patient> inOrderList = new ArrayList<>();
        collectInOrder(root, inOrderList);
        return inOrderList;
    }

    private void collectInOrder(Node current, List<Patient> list) {
        if (current != null) {
            collectInOrder(current.left, list);
            list.add(current.patient);
            collectInOrder(current.right, list);
        }
    }
}