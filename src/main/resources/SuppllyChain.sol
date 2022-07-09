// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.4.22 <0.8.0;
pragma experimental ABIEncoderV2;

contract SupplyChain {

    address private owner;

    enum UserType{
        FARMER,
        OFFICER
    }

    enum Stage {
        CULTIVATION,
        FERTILIZATION,
        HARVESTING,
        VALIDATION,
        PACKAGING
    }

    address id;
    string cultivationFieldAddress;
    uint batchId;
    bool cultivationDone;
    bool isLastEventFrtilization;
    bool packageDone;

    struct ProcessEvent {
        uint eventId;
        uint userId;
        string firstName;
        string lastName;
        UserType userType;
        string foodName;
        Stage stage;
        string date;
        string spec;
        string details;
        string certificateStatus;
    }


    event AddEntity(address id, uint batchId);
    uint eventSize = 1;

    mapping(uint => ProcessEvent) processEvents;

    modifier isOwner {
        require(owner == msg.sender, "You are not the contract owner");
        _;
    }

    constructor() public {
        owner = msg.sender;
    }

    function addEvent(ProcessEvent memory _event) public {

        if ( cultivationDone ) {
            require( _event.stage != Stage.CULTIVATION, "Cultivation is one time process for this smart contract." );
        }

        if ( packageDone ) {
            require( _event.stage != Stage.PACKAGING, "Packaging is one time process for this smart contract." );
        }

        if ( isLastEventFrtilization ) {
            require( _event.stage == Stage.VALIDATION, "Fertilization " );
        }

        _event.eventId = eventSize;
        processEvents[eventSize] = _event;
        eventSize++;

        if ( _event.stage == Stage.CULTIVATION ) {
            cultivationDone = true;
        }

        if ( _event.stage == Stage.PACKAGING ) {
            packageDone = true;
        }

        if ( _event.stage == Stage.FERTILIZATION ) {
            isLastEventFrtilization = true;
        }

        if ( _event.stage == Stage.VALIDATION ) {
            isLastEventFrtilization = false;
        }
    }

    function initializeContract(string memory _cultivationFieldAddress ,uint _batchId) public{

    }

    function getEvents() public view returns(ProcessEvent memory processEvent) {
        return processEvents[eventSize];
    }

}
