/**
 * 
 * @param {import('./domainResponses')} domainResponses
 */

const httpStatusCode = {
  OK: 200,
  CREATED: 201,
  NOT_FOUND: 404,
  CONFLICT: 409,
  BAD_REQUEST: 400,
};

const mapHttpStatus = (domainResponses) => httpStatusCode[domainResponses];

module.exports = mapHttpStatus;