package com.example.demo2;

public class WaitingList
{
    private Patient[] priorityQueue;
    private int size;
    private int capacity;

    public WaitingList(int capacity)
    {
        this.capacity = capacity;
        this.size = 0;
        this.priorityQueue = new Patient[capacity];
    }

    public void addToWaitList(Patient patient)
    {
        if (size >= capacity)
        {
            System.out.println("The waiting list is full.");
            System.out.println();
            return;
        }

        priorityQueue[size] = patient;
        size++;

        sortPriorityQueue();
        System.out.println(patient.getName() + " added to the waiting list.");
        System.out.println();
    }

    public void removeFromWaitList()
    {
        if (size == 0)
        {
            System.out.println("No patients in the waiting list.");
            System.out.println();
            return;
        }

        Patient removedPatient = priorityQueue[0];
        System.out.println(removedPatient.getName() + " removed from the waiting list.");
        System.out.println();

        for (int i = 1; i < size; i++)
        {
            priorityQueue[i - 1] = priorityQueue[i];
        }

        size--;
    }
    public String viewWait() {
        StringBuilder result = new StringBuilder();

        if (size == 0) {
            result.append("The waiting list is empty.\n");
        } else {
            result.append("Current Waiting List:\n");
            for (int i = 0; i < size; i++) {
                result.append(priorityQueue[i].toString()).append("\n");
            }
        }
        return result.toString();
    }

    public void viewWaitList()
    {
        if (size == 0)
        {
            System.out.println("The waiting list is empty.");
            System.out.println();
        } else
        {
            System.out.println("Current Waiting List:");
            for (int i = 0; i < size; i++)
            {
                priorityQueue[i].displayPatientInfo();
                System.out.println();
            }
        }
    }

    private void sortPriorityQueue()
    {
        if (size > 1)
        {
            mergeSort(priorityQueue, 0, size - 1);
        }
    }

    private void mergeSort(Patient[] array, int left, int right)
    {
        if (left < right)
        {
            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private void merge(Patient[] array, int left, int mid, int right)
    {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Patient[] leftArray = new Patient[n1];
        Patient[] rightArray = new Patient[n2];

        for (int i = 0; i < n1; i++)
        {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++)
        {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2)
        {
            if (leftArray[i].getPriority() <= rightArray[j].getPriority())
            {
                array[k] = leftArray[i];
                i++;
            }
            else
            {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}